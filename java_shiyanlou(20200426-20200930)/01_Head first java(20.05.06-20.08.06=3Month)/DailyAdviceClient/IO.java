//��PrintWriterд���ݵ�Socket��P479
Socket chatSocket =new Socket("127.0.0.1",5000);
PrintWriter writer=new PrintWriter(chatSocket.getOutputStream());
writer.println("message to send");
writer.print("another message");


//ʹ��BufferedReader��Socket�϶�ȡ����P478
Socket chatSocket =new Socket("127.0.0.1",5000);
InputStreamReader stream=new InputStreamReader(chatSocket.getInputStream());
BufferedReader reader =new BufferedReader(stream);
String message = reader.readline();


//�����л�����ԭ����P441
FileInputStream fileStream =new FileInputStream("MyGame.ser");
ObjectInputStream os =new ObjectInputStream(fileStream);

Object one =os.readObject();
Object two =os.readObject();

GameCharacter elf=(GameCharacter) one;
GameCharacter troll=(GameCharacter) two;

os.close();

//���л�����д���ļ�P432
//��FileWriter,���ַ���д���ı�P448
//��FileReader�����ı��е��ַ�����ȡ����P455