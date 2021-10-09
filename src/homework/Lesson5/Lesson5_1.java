package homework.Lesson5;

import org.omg.CORBA.ObjectHelper;

public class Lesson5_1 {
    public static class personAddress {
        String firstName;

        String secondName;

        String email;

        long phoneNumber;

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public String getEmail() {
            return email;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        personAddress(String FirstName, String SecondName) {
            firstName = FirstName;
            secondName = SecondName;
        }

        personAddress(String firstName, String secondName, String email, long phoneNumber) {
            this.firstName = firstName;
            this.secondName = secondName;
            setEmail(email);
            setPhoneNumber(phoneNumber);
        }

        @Override
        public boolean equals(Object object) {
            return object.getClass() == personAddress.class
                    && ((personAddress) object).getFirstName().contentEquals(getFirstName())
                    && ((personAddress) object).getSecondName().contentEquals(getSecondName());
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + getFirstName().hashCode();
            result = 31 * result + getSecondName().hashCode();
            return result;
        }
    }

    public static void main(String[] args) {
        personAddress test1 = new personAddress("三", "张", "abc@abc.com", 12345678901L),
                test2 = new personAddress("三", "张", "abc@abc.com", 23456789012L);
        System.out.printf("测试样例1的名字是: %s, 姓氏是: %s, 邮箱是: %s, 电话号码是: %d.\n",
                test1.getFirstName(), test1.getSecondName(), test1.getEmail(), test1.getPhoneNumber());
        System.out.printf("测试样例1是否与测试样例2相等? %s.", (test1.equals(test2)) ? "True" : "False");
    }
}
