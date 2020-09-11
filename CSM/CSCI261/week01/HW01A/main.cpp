/*
Author: Gage Coprivnicar
Section: A
Week: 0
Lab C
*/

#include <iostream>
using namespace std;

int main() {

//variables
int age;
double jump_height;
int cookies;
int classes;

//ascii art
cout << "...$ZZZ$$$$....................................................................." << endl
<< "........O8OOZZZZ$?$$............................................................" << endl
<< "........D888OOOZZ:$..$.........................................................." << endl
<< ".......888888OOZ?.7~..Z........................................................." << endl
<< "......8D8888OOOOZ,.Z$$Z7........................................................" << endl
<< ".....8DDD8888OOOOO,,,,ZO........................................................" << endl
<< "....$DDDD88888OOOOOOOOOOOOZ$Z........................................ ... ... .." << endl
<< "....DDDDD8888888888888ODDDDD8...+-------------+................................." << endl
<< "...~DDDDD88888888888OZODD8......| IM HAPPY!!!!|................................." << endl
<< "...8DDDDDD8DDDDDDZZZZZI$...... ++-------------+..............................." << endl
<< "..8DDDDDDDDDOZZZ               ++............................... ................" << endl
<< ".8DDDDDDDN$777ZZ   ~~~~~~~    +++..............................................." << endl
<< ".DDDDDDDNN777IZZ    |.|  |.|  +++..............................................." << endl
<< ".8DDDOONNNN777ZZ              ......... .... . ................................." << endl
<< "..I77$$7ZNNNN7ZZ   |+-----+|  ............,,.=I=:..~..+........................." << endl
<< "...7Z$$OO7NNNNZZ              ....:.:???=, ~~  ,,N ............................." << endl
<< "...+=,ZZZZ77$777MMNNNMMNNIIII.,8D7.III:=,I+,.~..,... .7........................." << endl
<< "....,I,ZZ$$777778MMNNMMMMMMDDDDNN$O$IIII?=:...,....?I..........................." << endl
<< ".......$$$NO77777$MMMMM$$DDDDDNDD$ZO$7777III?+,.??.............................." << endl
<< ".........NNN$77777$$ON8N~8DDDDDDDD$8$$$$OOOD???+................................" << endl
<< ".........NNNN$77777++7$$DDDDDDDDNNN$O$$DDOO$7..................................." << endl
<< "....     .=NMI$$777I+7IODDDDNDO...   .Z$$O$I+. .                ................" << endl
<< "........ ...DDO$$7$7$$NDDNN$...... .O?88888O,. ... . . . . . . ................." << endl
<< ".... ....8DD88DD8ZZO88NNN.. ......~$88888888888~................................" << endl
<< ".... ..D8OOZZZOOZ88OODNN..      .ZNO88OO888888ONN$..            ................" << endl
<< ".....,8OOZZZZZZOZ$OOODDN.......O88O.... ..O8ODNNNN.............................." << endl
<< "....88OOOOOOOOODO8OO8NDD.. . .ZD8:......:..88NNNNN.. ......... ................." << endl
<< "...8OOOZOOOO8DODOOOODNND....ON88OIOO7..ZO.+ODNNNNNZ....NNN88I..................." << endl
<< "..8OOOOOO88DND8DOOOONNNN:.IZ8888Z...788,.$8NNNNNNNNDNNNNNNDD8ND8O..............." << endl
<< ".DOOZZZZDDNNNDDNOO88DDD$IZNO88888O.....O8OINDNNNNNNNNNNNNNNNN888NND............." << endl
<< ".D8OOOZZZZ$...78?+~DDDDOODN88888888888DDD7=N8DNNDMMNNNNNNNNNDDDD88D88..........." << endl
<< ".DDD88OOO:.=++=..==~..ID8$..MO88888DDDD$7~.NODDDDNMNNNNNNMNNMNNDDN88D88........." << endl
<< "..DDDDD8+:?II+??=,.Z=:.I$$O,...NDDDDDD777$77O8DDNMMMMNNMNNNNNNNNDD8N88N8........" << endl
<< "..DDDDD8+7I7I~.8Z7+,.~~,~I.....MMMMN8OZDOOZDM8DDNMMMMMNMNNMMNNNNNNDD8D8D88......" << endl
<< ".DDDDDD$$7III7?:$8$7+..=8OOOO.NMMMMNNNDD88DOOODO7MMMMN8ZDNMNMMNNNNNDDDD88N8....." << endl
<< ".DDDDDDD$87I+,.I?ZON777$8888ODNNNDDOMNNNMM88D888D8DMNN?8Z7Z8MMNNNNNDDDD888N8?..." << endl
<< ".DDDDDDDNZ8$77=.OZ$8OD8NDDD8NNNNNNNDDDMMMN8DN8ODZ$78ON$ZZIDNDDMMNNMNNDDDDD88D..." << endl
<< ".DDDDDDDDNNNMN$$$NDODDDNDNNN?+=+++=~.MNDNM8DD+78ZOOZZZZ+ZOONDDNNNNMNNNDDDDN8DD.." << endl
<< ".DDDDDDDDDDNNNNNNND8DNDDDD7I7I???+==.MNNMN88DOO=8NZ7O8$$O$O8DDDD8MNNMNNNNDDDDN8." << endl
<< "..8DDDDDDDDDDNNNNN77DDDDN87777I?++==:DMMMND8DZ?=O88~.$78O77ZOOZDD8NMNMNNNMNDND8." << endl
<< "...8DDDDDDD888DNNNDD...NMI7777I??+==DNNNNNM8DOO8888. ..N8Z$?88OI?78NMNNNNNNNNDN." << endl
<< ".....8DDDDD88DDDDDDD:.MM8NNNNNN??++=NNNNNDN88N=~MMO  ....MMN88Z$7$O8MMMMNNNNDMD." << endl
<< "......:8DDDDDDDDDDDDDNNN$78NNNNDDD=NNDNNNDD88DMMMMO$..... 7IMNNN88O8MMMNNNNMNN.." << endl
<< ".... .. ~DD8DDDDD8DDDDDDDDD$$8NDDDDNNDDNNDM888NN8M+I$...... ZNNNNNNNMMMMMNNNND.." << endl
<< "........ .DDDD88OODD888$I$DDD7IIDD8NNDD8DND8O8DDNO7II......... NMMMNMMMMMMMN,..." << endl
<< "..........8DDD888DD88OZ7IONNNDI??+Z8O8D8NN88Z.D8N8888.............NMNNNNNI......" << endl
<< "..........ODD88DDDD88OODOODDD8I???8ZOOD8DNNNODD8O$O8.... . . . ................." << endl
<< ".........I8DDD8DDDD88888DDDDDDDDNNNND88O8OOZ7I7$ZO=. .   .   .  ................" << endl
<< "........DNNDD88DDDDDDODDDDDDDDDNDDDDD8OOZ$$ZO+,8II.............................." << endl
<< ".......NN=+DDDDDDDDDODDDDDDDD8DNDNDDD888ZIIIZ7.::~7............................." << endl
<< "......NNN++DD8NDDDD88888888888D88OMNDD,:7MNZ$$$ZZOO ............................" << endl
<< ".... .Z8DN+D+DDDDDNO88888888DN888ND~?DDMMND$$$O$$$ZZ ..........................." << endl
<< ".... DNZIN+DNDDDDDODD8O8OONM8888NDD?DDMMNNIIZZZOO88DN..........................." << endl
<< ".....NNINN=I=~8D8O?+?77+Z7NND8DD88DDODMMM8DNNNNNNMMO............................" << endl
<< "..... ....8NN$:DD8OOZ~=ZZD 8DDN88OD8MM=MNNNO888NMM ............................." << endl
<< "................$O888888.ODDDDDNNDMMMMMNMDDDDDMM. .............................." << endl
<< ".... . . . . . ...:8$.....D8DDD88ONMMMMZMNO....................................." << endl
<< ".... .          .........$.NDD8:?+?=M8Z,D: ....................................." << endl
<< "........        ....+DNNNNDNDDZ7Z?DDDD7D=.                      ................" << endl
<< "........  .   . .ONNNNNNNDDD8IN8ZNNND7D .                       ................" << endl
<< ".... .        ..NNNNNNNNDDD87NNNNNND7N.........................................." << endl
<< "............. NNNNNNNNNDNOD7NNNNDNN7M,.... ... ... ... ... ... ................." << endl
<< "....  . .....8NNNNNNNM8N887NNNND88DN,. . . . . . . . . . . . . ................." << endl
<< ".............NNNNNDDDDND87NNNNN888DO............................................" << endl
<< ".... .      DNNNND$ODD88$NNNNND88N8D............................................" << endl
<< "........    ,NNND7ZNNN8$ODNNND8DO88DI... ... ... ... ... ... ..................." << endl
<< "....     . .NNNNDODDDD8DDDMNND88N8DDN..........................................." << endl
<< ".........  .,NNN8DDDD88DN8NNNN88N8NDD..........................................." << endl
<< ".... ...    $NNNNODD888DD88NNN88N8NDN..........................................." << endl
<< "...... .    .NNNNDOZDOODDDNNNN8DNDDDN..........................................." << endl
<< ".........   .NNNNN8Z7$$7ZDNNNNDDNDND..   .   .   .   .   .   .  ................" << endl
<< "........ . .. MNNNNDOI$DDNNNNDDDDNNN............................................" << endl
<< "....          .NNNNNNNNNNNNNNNNNNNN............................................." << endl
<< "....          ..NNNNNNNNNNNNNNNNNM..                            ................" << endl
<< ".................7NNNNNNNNNDNNNN+..............................................." << endl
<< "....     . . . .....MNNNNNNNNM.................................................." << endl
<< "" << endl
<< "" << endl;

//age
cout << "We are going to be asking you some questions." << endl;
cout << "How old are you?: ";
cin >> age;
//jump height
cout << "How high can you jump (ft)?: ";
cin >> jump_height;
//number of cookies eaten
cout << "How many cookies have you eaten today?: ";
cin >> cookies;
//number of classes
cout << "How many classes are you taking this semester?: ";
cin >> classes;

cout << "Cool, cool thanks, so it seems like you are " << age << " years old." << endl
<< "You can jump " << jump_height << "ft high, pretty good. " << endl
<< "You also ate " << cookies << " cookie(s) yesterday and have " << classes << " classes this semester" << endl;

cout << "Thanks for your input, have a nice day" << endl;

return 0;
}
