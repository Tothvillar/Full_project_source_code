import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class new_student_management_system {
    public static void main(String[] args) {
        ArrayList<user> list = new ArrayList<>();
        System.out.println("欢迎来到学生管理系统");
        while (true) {
            System.out.println("请选择操作1.登录 2.注册 3.忘记密码");
            Scanner sc=new Scanner(System.in);
            int num= sc.nextInt();
            switch (num)
            {
                case 1->login(list);
                case 2->enroll(list);
                case 3-> forgot_password(list);
            }
        }
    }
    public static void enroll(ArrayList<user> list)
    {
        user u1=new user();
        while (true){
        System.out.println("请输入您的用户名：");
        Scanner sc1=new Scanner(System.in);
        String tmp= sc1.next();
        if(judgment_userName(list,tmp))
        {
            u1.setUser_name(tmp);
            while (true) {
                System.out.println("请输入密码：");
                Scanner sc2=new Scanner(System.in);
                String frist_PassWord= sc2.next();
                System.out.println("请再次输入密码：");
                Scanner sc3=new Scanner(System.in);
                String second_PassWord=sc3.next();
                if (frist_PassWord.equals(second_PassWord)){
                    u1.setPassWord(frist_PassWord);
                    while (true) {
                        System.out.println("请输入您的身份证号：");
                        Scanner sc4=new Scanner(System.in);
                        String id=sc4.next();
                        if(judgment_id(id)){
                            u1.setIdentification_number(id);
                            while (true) {
                                System.out.println("请输入你的手机号码：");
                                Scanner sc5=new Scanner(System.in);
                                String phoneNumber=sc5.next();
                                if(judgment_phoneNumber(phoneNumber)){
                                    u1.setPhone_number(phoneNumber);
                                    break;
                                }else {
                                    System.out.println("对不起，手机号码有误，请重新输入");
                                }
                            }
                            break;
                        }else {
                            System.out.println("对不起，身份证号码有误，请重新输入");
                        }
                    }
                    break;
                }else {
                    System.out.println("对不起，两次密码不一致，请重新输入");
                }

            }
            break;
        }else {
            System.out.println("对不起，用户名输入错误，请重新输入");
        }
        }
        list.add(u1);
    }
    public static boolean judgment_userName(ArrayList<user> list,String tmp){//判断用户名
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUser_name().equals(tmp))
            {
                return false;
            }

        }
        if (!(tmp.length()>=3&&tmp.length()<=15)){
            return false;
        }
        int count=0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i)>='0'&&tmp.charAt(i)<='9')
                count++;
            if (!((tmp.charAt(i)>='a'&&tmp.charAt(i)<='z')||(tmp.charAt(i)>='A'&&tmp.charAt(i)<='Z'))) {
                return false;
            }
        }
        if(count==tmp.length())
        {
            return false;
        }
        return true;
    }
    public static boolean judgment_id(String id){
        if (id.length()!=18){
            return false;
        }
        for (int i = 0; i < id.length()-1; i++) {
            if (!(((id.charAt(i)>='0'&&id.charAt(i)<='9'))&&id.charAt(0)!=0)){
                return false;
            }
        }
        if (!(id.charAt(17)=='x'||id.charAt(17)=='X'||(id.charAt(17)>='0'&&id.charAt(17)<='9'))) {
            return false;
        }
        return true;
    }
    public static boolean judgment_phoneNumber(String phoneNumber){
        if (phoneNumber.length()!=11)
        {
            return false;
        }
        else if(phoneNumber.charAt(0)==0){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if(!(phoneNumber.charAt(i)>='0'&&phoneNumber.charAt(i)<='9')){
                return false;
            }
        }
        return true;
    }
    public static void login(ArrayList<user> list){
        System.out.println("请输入你要登录的用户名：");
        Scanner sc6=new Scanner(System.in);
        String userName=sc6.next();
        int count=3;
        while(count>0){
        if(login_judgment_userName(list,userName)!=-1){
            System.out.println();
            System.out.println("请输入你的密码：");
            Scanner sc7=new Scanner(System.in);
            String input_Password=sc7.next();
            if(list.get( login_judgment_userName(list,userName)).getPassWord().equals(input_Password)){
                System.out.println("请输入验证码：");
                String system_Captcha=Captcha();
                Scanner sc8=new Scanner(System.in);
                String captcha=sc8.next();
               if(captcha.equals(system_Captcha)){
                   System.out.println("密码正确");
                   count=0;
               } else {
                   System.out.println("验证码错误");
                   System.out.print("请重新输入");
               }
            }else {
                System.out.println("请输入验证码：");
                String system_Captcha=Captcha();
                Scanner sc8=new Scanner(System.in);
                String captcha=sc8.next();
                if(captcha.equals(system_Captcha)){
                    System.out.println("密码错误，请重新输入,还有"+(count-1)+"次机会");
                    count--;
                }
                else {
                    System.out.println("验证码错误");
                    System.out.print("请重新输入");
                }

            }
            }
        else {
            System.out.println("用户未注册");
            break;
        }
        }

    }
    public static int login_judgment_userName(ArrayList<user> list,String userName){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUser_name().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    public static String Captcha(){
            String arr="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random Random = new Random();
        int RandomNumber = Random.nextInt(arr.length());
            StringBuilder generateCaptcha= new StringBuilder(arr.charAt(RandomNumber));

        while (true) {
            for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(arr.length());
            generateCaptcha.append(arr.charAt(randomNumber));

        }
            int count=0;
            for (int i = 0; i < generateCaptcha.length(); i++) {
                if(generateCaptcha.charAt(i)>='0'&&generateCaptcha.charAt(i)<='9'){
                    count++;
                }
            }
            if(count==1){
                System.out.println(generateCaptcha);
                return generateCaptcha.toString();
            }else {
                generateCaptcha.delete(0,5);
            }
        }

    }
    public static void forgot_password(ArrayList<user> list){
        System.out.println("请输入用户名：");
        Scanner sc9=new Scanner(System.in);
        String user_Name= sc9.next();
        int tmp=login_judgment_userName(list,user_Name);
        if(tmp==-1){
            System.out.println("未注册");
        }else {
            System.out.println("请输入身份证号：");
            Scanner sc10=new Scanner(System.in);
            String tmp_id=sc10.next();
            System.out.println("请输入手机号码：");
            Scanner sc11=new Scanner(System.in);
            String tmp_phone_number=sc11.next();
            if(Objects.equals(list.get(tmp).getPhone_number(), tmp_phone_number)&&Objects.equals(list.get(tmp).getIdentification_number(), tmp_id)){

                System.out.println("请输入密码：");
                Scanner sc12=new Scanner(System.in);
                String frist_PassWord= sc12.next();
                System.out.println("请再次输入密码：");
                Scanner sc13=new Scanner(System.in);
                String second_PassWord=sc13.next();
                if(frist_PassWord.equals(second_PassWord)){
                    list.get(tmp).Change_password(second_PassWord);
                    System.out.println("修改成功");
                }
            }
        }


    }
}
