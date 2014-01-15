<h3>文法说明</h3>
1、	文法开始：<br />
S-&gt;void main(){A}<br />
2、	声明：<br />
X-&gt;YZ;<br />
Y-&gt;int|char|bool<br />
Z-&gt;UZ’<br />
Z’-&gt;,Z|$&nbsp;<br />
U-&gt;idU’<br />
U’-&gt;=L|$<br />
3、	赋值：<br />
R-&gt;id=L;<br />
4、	算术运算：<br />
L-&gt;TL’<br />
L’-&gt;+L|-L|$<br />
T-&gt;FT’<br />
T’-&gt;*T|/T|$<br />
F-&gt;(L)<br />
F-&gt;id|num<br />
O-&gt;++|--|$<br />
Q-&gt;idO|$<br />
5、	布尔运算<br />
E-&gt;HE’<br />
E’-&gt;&amp;&amp;E|$<br />
H-&gt;GH’<br />
H’-&gt;||H<br />
H’-&gt;$<br />
G-&gt;FDF<br />
D-&gt;&lt;|&gt;|==|!=<br />
G-&gt;(E)<br />
G-&gt;!E<br />
5、控制语句<br />
B-&gt;if (E){A}else{A}<br />
B-&gt;while(E){A}<br />
B-&gt;for(YZ;G;Q){A}<br />
6、功能函数<br />
B-&gt;printf(P);<br />
B-&gt;scanf(id);<br />
P-&gt;id|ch|num<br />
<br />
<br />
7、复合语句<br />
A-&gt;CA<br />
C-&gt;X|B|R<br />
A-&gt;$<br />
<br />
<br />
1、构造LL1属性翻译文法<br />
构造LL1属性翻译文法即在原有LL1文法基础上加上动作符号，并给非终结符和终结符加上一定属性，给动作符号加上语义子程序。对原有LL1文法改进的地方如下：<br />
1、	赋值：<br />
产生式			语义子程序<br />
<br />
<br />
R-&gt;@ASS_R id =L@ EQ;	 @ASS{R.VAL=id并压入语义栈}<br />
@EQ{RES=R.VAL,OP=’=’,ARG1=L.VAL,<br />
new fourElement(OP,ARG1,/, RES)}<br />
U-&gt;@ASS_UidU’ 		{U.VAL=id并压入语义栈}<br />
U’-&gt;=L|$@EQ_U’ 	{RES=U.VAL,OP=’=’,ARG1=L.VAL,new fourElement(OP,ARG1,/, RES)}<br />
<br />
<br />
2、	算术运算：<br />
产生式			语义子程序<br />
<br />
<br />
L-&gt;TL’@ADD_SUB	{If(OP!=null) RES= NEWTEMP; L.VAL=RES,并压入语义栈;New fourElement(OP, T.VAL;,L’VAL, RES)，<br />
}<br />
L’-&gt;+L@ADD	{OP=+,ARG2=L.VAL}<br />
L’-&gt;-L@SUB	{OP=-,ARG2=L.VAL}<br />
L’-&gt;$ <br />
T-&gt;FT’@DIV_MUL	{ if (OP !=null) RES= NEWTEMP;T.VAL=RES;&nbsp;<br />
new FourElement(OP,F.VAL,ARG2, RES)<br />
else ARG1=F.VAL; }<br />
T’-&gt;/T@DIV		{OP=/,ARG2=T.VAL}<br />
T’-&gt;*T@MUL	 {OP=*,ARG2=T.VAL}<br />
T’-&gt;$<br />
F-&gt;(L)@VOL		{F.VAL-&gt;L.VAL}<br />
F-&gt;@ASS_F num|id		{F.VAL=num|id}<br />
Q-&gt;idO|$<br />
O-&gt;@SINGLE_OP++|--	{OP=++|--}<br />
<br />
<br />
3、	布尔运算<br />
产生式			语义子程序<br />
<br />
<br />
G-&gt;FDF@COMPARE{OP=D.VAL;ARG1=F(1).VAL;ARG2=F(2).VAL,RES=NEWTEMP;&nbsp;<br />
New fourElement(OP,F.VAL,ARG2, RES );G.VAL=RES并压入语义栈}<br />
D-&gt;@COMPARE_OP&lt;|&gt;|==|!={D.VAL=&lt;|&gt;|==|!=,并压入语栈}<br />
<br />
<br />
4、	控制语句<br />
产生式			语义子程序<br />
B-&gt;if (G)@IF_FJ{A}@IF_BACKPATCH_FJ @IF_RJ else{A}@IF_BACKPATCH_RJ<br />
@IF_FJ{OP=”FJ”;ARG1=G.VAL;RES=if_fj, New fourElement(OP,ARG1,/, RES ),将其插入到四元式列表中第i个}<br />
@IF_BACKPATCH_FJ{回填前面假出口跳转四元式的跳转序号, BACKPATCH (i,if_fj)}<br />
B-&gt;while(G)@WHILE_FJ{A}@WHILE_RJ@WHILE_BACKPATCH_FJ		{参照if else}<br />
B-&gt;for(YZ;G@FOR_FJ;Q){A@SINGLE}@FOR_RJ@FOR_BACKPATCH_FJ			{参照if else }<br />
@SINGLE	{ARG1=id;RES=NEWTEMP;New fourElement(OP,ARG1,/,RES)}<br />
<br />
说明：<br />
（1）、R.VAL表示符号R的值，VAL是R的一个属性，其它类似。<br />
（2）、NEWTEMP()函数：每调用一次生成一个临时变量，依次为T1，T2，…Tn。<br />
（3）、BACKPATCH (int i,int res):回填函数，用res回填第i个四元式的跳转地址。<br />
（4）、new fourElement（String OP,String ARG1,String ARG2,String RES ）:生成一个四元式<br />
（OP,ARG1,ARG2,RES）<br />
<div>
<br />
</div>
