package Homework.Lesson5;

public class Lesson5_1 {
    /**
     * personAddress类, 存放了姓氏, 名字, 邮箱以及手机号码四个数值成员.
     * 包含4个Getter和2个Setter.
     * 提供2个不同的构造函数以对应只提供姓名以及提供姓名、邮箱和手机号码的初始化情景.
     *
     * @author 张泽贤
     */
    public static class personAddress {
        String firstName;

        String secondName;

        String email;

        long phoneNumber;

        /**
         * @return 返回名字.
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @return 返回姓氏.
         */
        public String getSecondName() {
            return secondName;
        }

        /**
         * @return 返回邮箱.
         */
        public String getEmail() {
            return email;
        }

        /**
         * @return 返回电话号码.
         */
        public long getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * 更改联系人邮箱.
         * 
         * @param email 更改的邮箱.
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * 更改联系人手机号码.
         * 
         * @param phoneNumber 更改的电话号码.
         */
        public void setPhoneNumber(long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        /**
         * 构造函数, 仅提供联系人的姓氏与名字.
         *
         * @param FirstName  联系人的名字.
         * @param SecondName 联系人的姓氏.
         * @see personAddress#personAddress(String, String, String, long) 提供邮箱以及手机号码的构造函数.
         */
        personAddress(String FirstName, String SecondName) {
            firstName = FirstName;
            secondName = SecondName;
        }

        /**
         * 提供所有信息的构造函数.
         *
         * @param email 联系人邮箱.
         * @param phoneNumber 联系人手机号码.
         * @see personAddress#personAddress(String, String) 缺省了邮箱以及手机号码的构造函数.
         */
        personAddress(String firstName, String secondName, String email, long phoneNumber) {
            this.firstName = firstName;
            this.secondName = secondName;
            setEmail(email);
            setPhoneNumber(phoneNumber);
        }

        /**
         * 覆写equals()函数, 仅判断联系人实例姓名是否相等.
         * 
         * @param object 一个对象的实例, 可传入任意对象的实例.
         * @return 返回一个布尔值表示实例是否同为personAddress的实例且为同一联系人(仅比较姓名).
         * @see Object#equals(Object) 被覆写的父类方法.
         * */
        @Override
        public boolean equals(Object object) {
            return object.getClass() == personAddress.class
                    && ((personAddress) object).getFirstName().contentEquals(getFirstName())
                    && ((personAddress) object).getSecondName().contentEquals(getSecondName());
        }

        /**
         * 同时覆写hashCode()方法, 仅考虑了姓氏和名字关键值.
         *
         * @return 返回实例的哈希值.
         * @see Object#hashCode() 被覆写的父类方法.
         * */
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
