package Item1;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankCard {
	public String bank;
	public String name;
	public int card;
	public String password;
	public String ID;
	public String OTime;//����ʱ��
	public static float balance=5000;
	
	BankCard(){
		bank="�й�����";
		name="������";
		card=100000;
		ID="000000";
		OTime="2018/01/01";
		password="000000";
	}
	
public boolean submit(String mypassword) {
	boolean b=false;
	if(mypassword.equals(password))
		b=true;
	return b;
}
public float balance() {
	float d=balance;
	System.out.println("���Ŀ������Ϊ��"+d+"Ԫ");
	return d;
}
public void takeout(float money) {
	DBConnection dBConnection = new DBConnection();{
		if(money<=balance) {
			float d=balance-money;
			balance=d;
			/*���ݿ����*/
			int result = dBConnection.updata(balance,card);
			System.out.println("����ȡ����Ϊ��"+money+"Ԫ\n���Ŀ������Ϊ��"+d+"Ԫ");
		}
		else {
			JOptionPane.showMessageDialog(null, "�˻����� !","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		}
	
	}
}
public void save(float money) {
	DBConnection dBConnection = new DBConnection();
	float d=balance+money;
	balance=d;
	int result = dBConnection.updata(balance,card);
	System.out.println("���Ĵ����Ϊ��"+money+"Ԫ\n���Ŀ������Ϊ��"+d+"Ԫ");
}
	
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		BankCard c1=new BankCard();
//		System.out.println("���������룺");
//		Scanner sc=new Scanner(System.in);
//		String mypassword=sc.next();
//		boolean b=c1.submit(mypassword);
//		int flag=1;
//		while(flag==1)
//		{
//		if(b)
//		{
//			System.out.println("��"+c1.bank+"����ӭ����"+c1.name+"���Ŀ���Ϊ��"+c1.cardNumber+"����ѡ�����в�����");
//			System.out.println("1.��ѯ���");
//			System.out.println("2.ȡ��");
//			System.out.println("3.���");
//			System.out.println("4.��ʾ�˻���Ϣ");
//			System.out.println("5.�˳�");
//		}
//		else
//			System.out.println("������󣡣���");
//		int i=sc.nextInt();
//		
//			switch(i)
//			{
//			case 1:
//				c1.balance();
//				System.out.println("�Ƿ������\n���� ��1��   �˳� ��0��");
//				flag=sc.nextInt();
//				if(flag==0)
//					System.out.println("ллʹ�ã��ټ���");
//				break;
//			case 2:
//				System.out.print("������ȡ���");
//				double j=sc.nextDouble();
//				c1.takeout(j);
//				System.out.println("�Ƿ������\n���� ��1��   �˳� ��0��");
//				flag=sc.nextInt();
//				if(flag==0)
//					System.out.println("ллʹ�ã��ټ���");
//				break;
//			case 3:
//				System.out.print("������ȡ���");
//				double k=sc.nextDouble();
//				c1.save(k);
//				System.out.println("�Ƿ������\n���� ��1��   �˳� ��0��");
//				flag=sc.nextInt();
//				if(flag==0)
//					System.out.println("ллʹ�ã��ټ���");
//				break;
//			case 4:
//				System.out.println(""+c1.bank);
//				System.out.println("���ţ�"+c1.cardNumber);
//				System.out.println("������"+c1.name);
//				System.out.println("���֤�ţ�"+c1.ID);
//				System.out.println("����ʱ�䣺"+c1.OTime);
//				System.out.println("��"+c1.balance());
//				System.out.println("�Ƿ������\n���� ��1��   �˳� ��0��");
//				flag=sc.nextInt();
//				if(flag==0)
//					System.out.println("ллʹ�ã��ټ���");
//				break;
//			case 5:
//				System.out.println("ȷ���˳���\n���� ��1��   �˳� ��0��");
//				flag=sc.nextInt();
//				if(flag==0)
//					System.out.println("ллʹ�ã��ټ���");
//				break;
//			default:
//				System.out.println("�������");
//			}
//		}
//	}

}
