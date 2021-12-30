package Homework.Lesson6;

class RoomOccupancy {
    int numberInRoom;
    static int totalNumber;

    /**
     * 向房间内添加一个人
     */
    public void addOneToRoom() {
        ++numberInRoom;
        ++totalNumber;
    }

    /**
     * 如果numberInRoom > 0, 则从房间内减少一个人
     */
    public void removeOneFromRoom() {
        if(getNumber() > 0) {
            --numberInRoom;
            --totalNumber;
        }
    }

    /**
     * @return 在房间内的人数
     */
    public int getNumber() {
        return numberInRoom;
    }

    /**
     * @return 总人数
     */
    public static int getTotal() {
        return totalNumber;
    }
}

public class Lesson6_1 {
    public static void main(String[] args) {
        RoomOccupancy room1 = new RoomOccupancy(),
                room2 = new RoomOccupancy();
        for(int i = 0; i < 2; ++i)
            room1.addOneToRoom();
        for(int i = 0; i < 3; ++i)
            room2.addOneToRoom();
        System.out.printf("room1内有%d人, room2内有%d人, 总共有%d人.\n", room1.getNumber(), room2.getNumber(), RoomOccupancy.getTotal());
        room1.removeOneFromRoom();
        System.out.printf("room1内有%d人, room2内有%d人, 总共有%d人.\n", room1.getNumber(), room2.getNumber(), RoomOccupancy.getTotal());
    }
}
