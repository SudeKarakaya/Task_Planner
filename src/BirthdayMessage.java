import java.util.Date;

public class BirthdayMessage extends MessageDecorator{

    BasicMessage basicMessage;

    String birthday;

    public BirthdayMessage (String birthday){
        this.birthday = birthday;
    }
    @Override
    public String getDay() {
        return basicMessage.getDay();
    }

    @Override
    public String getDate() {
        return basicMessage.getDate();
    }

    public String getBirthdayMessage(){
        return "Happy Birthday!";
    }

    public String getBirthday(){
        return birthday;
    }


}
