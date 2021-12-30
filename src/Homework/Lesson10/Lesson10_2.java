package Homework.Lesson10;

import Homework.Lesson8.Pet;

import java.io.*;
import java.util.Scanner;

class SerializablePet extends Pet implements Serializable {
    public SerializablePet() {
        super();
    }

    public SerializablePet(String initialName, int initialAge, double initialWeight) throws Exception {
        super(initialName, initialAge, initialWeight);
    }

    public SerializablePet(String initialName) {
        super(initialName);
    }

    public SerializablePet(int initialAge) throws Exception {
        super(initialAge);
    }

    public SerializablePet(double initialWeight) throws Exception {
        super(initialWeight);
    }

    private static final long serialVersionUID = 42L;

    private void readObjectNoData()
            throws Exception {
        setName("No name yet.");
        setAge(0);
        setWeight(0);
    }
}

public class Lesson10_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //存储读出的Pet实例
        SerializablePet[] array = new SerializablePet[1];
        array[0] = new SerializablePet();

        int op;
        do {
            System.out.println("Please choose an operation among below an type its number to execute:\n" +
                    "0. Exit.\n" +
                    "1. Read an Pet object from the file given and output it to the screen.\n" +
                    "2. Write an Pet object to the file given.\n" +
                    "Enter an integer to perform an operation: ");

            op = scanner.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1: {
                    System.out.println("Please enter the name of file in the next line and press Enter button: ");
                    scanner.nextLine();
                    String fileName = scanner.nextLine();
                    System.out.println("Please enter the number of the record you want to read: ");
                    int n = scanner.nextInt();

                    try {
                        ObjectInputStream objectInputStream =
                                new ObjectInputStream(new FileInputStream(new File(fileName)));
                        array = new SerializablePet[n];
                        for (int i = 0; i < n; i++) {
                            array[i] = (SerializablePet) objectInputStream.readObject();
                            System.out.println(array[i]);
                            Thread.sleep(1000);
                        }
                        objectInputStream.close();
                    } catch (FileNotFoundException fileNotFoundException) {
                        //读入时若文件不存在直接进行下一次操作
                        System.out.println("The file does not exist!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2:
                    System.out.println("Please enter the name of file in the next line and press Enter button: ");
                    scanner.nextLine();
                    String fileName = scanner.nextLine();
                    File file = new File(fileName);

                    if (!file.exists() || !file.isFile()) {
                        System.out.println("The file does not exist, would you like to create one?\n" +
                                "Enter \"True\" or \"False\"(case insensitive): ");
                        String tmp = scanner.nextLine();
                        if (tmp.equalsIgnoreCase("True")) {
                            File parent = file.getParentFile();
                            if (parent != null) {
                                parent.mkdirs();
                            }
                            try {
                                file.createNewFile();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } else if (tmp.equalsIgnoreCase("False")) {
                            break;
                        } else {
                            System.out.println("Invalid input!");
                            break;
                        }
                    }

                    try {
                        ObjectOutputStream objectOutputStream =
                                new ObjectOutputStream(new FileOutputStream(file));
                        if (array.length == 0) {
                            System.out.println("You have nothing to write!");
                            break;
                        }
                        System.out.println("Choose the Pet instance you want to write and enter its order when it's read: ");
                        int pos = scanner.nextInt();
                        if (pos >= array.length) {
                            System.out.println("Index out of bounds! Please try again.");
                            break;
                        }
                        objectOutputStream.writeObject(array[pos]);
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    System.out.println("Wrong number! Please try again.");
                    break;
            }
        } while (op != 0);
    }
}
