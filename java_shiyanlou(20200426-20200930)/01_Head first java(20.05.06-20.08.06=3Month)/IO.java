//用PrintWriter写数据到Socket上P479
Socket chatSocket =new Socket("127.0.0.1",5000);
PrintWriter writer=new PrintWriter(chatSocket.getOutputStream());
writer.println("message to send");
writer.print("another message");


//使用BufferedReader从Socket上读取数据P478
Socket chatSocket =new Socket("127.0.0.1",5000);
InputStreamReader stream=new InputStreamReader(chatSocket.getInputStream());
BufferedReader reader =new BufferedReader(stream);
String message = reader.readline();


//节序列化：还原对象P441
FileInputStream fileStream =new FileInputStream("MyGame.ser");
ObjectInputStream os =new ObjectInputStream(fileStream);

Object one =os.readObject();
Object two =os.readObject();

GameCharacter elf=(GameCharacter) one;
GameCharacter troll=(GameCharacter) two;

os.close();

//序列化对象写入文件P432
//用FileWriter,将字符串写入文本P448
//用FileReader，将文本中的字符串读取出来P455