package HospitalProject.Controller.Domain.HospitalConfiguration.HospitalRoom;

import javax.persistence.*;

@Entity
@Table(name = "HospitalRooms")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "room_type", discriminatorType = DiscriminatorType.STRING)
public class HospitalRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roomNumber;

    public void setId(int id) {
        this.id = id;
    }

    public HospitalRoom() {
        // Default constructor for JPA
    }

    public HospitalRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "HospitalRoom{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
