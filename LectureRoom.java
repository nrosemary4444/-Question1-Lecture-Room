/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.lectureroom;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class LectureRoom {

    private int numberOfStudents;
    private boolean[] lights;
    public LectureRoom() {
        this.numberOfStudents = 0;
        this.lights = new boolean[3]; // Three lights, initialized to off (false)
    }

    public void addStudents(int number) {
        this.numberOfStudents += number;
    }

    public void removeStudents(int number) {
        if (this.numberOfStudents >= number) {
            this.numberOfStudents -= number;
        } else {
            this.numberOfStudents = 0;
        }
    }

    public void turnOnLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            this.lights[lightNumber - 1] = true;
        } else {
            System.out.println("Invalid light number. Please choose between 1 and 3.");
        }
    }

    public void turnOffLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            this.lights[lightNumber - 1] = false;
        } else {
            System.out.println("Invalid light number. Please choose between 1 and 3.");
        }
    }

    @Override
    public String toString() {
        StringBuilder status = new StringBuilder();
        status.append("Number of Students: ").append(this.numberOfStudents).append("\n");
        status.append("Lights Status: ");
        for (int i = 0; i < lights.length; i++) {
            status.append("Light ").append(i + 1).append(" is ");
            status.append(lights[i] ? "ON" : "OFF").append("\n");
        }
        return status.toString();
    }

     public static void main(String[] args) {
        LectureRoom room = new LectureRoom();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            // Display the menu
            System.out.println("\n*** Main Menu ***");
            System.out.println("W: Add students to the room");
            System.out.println("X: Remove students from the room");
            System.out.println("Y: Turn on a light");
            System.out.println("Z: Turn off a light");
            System.out.println("Q: Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'W':
                    System.out.print("Enter the number of students to add: ");
                    int addStudents = scanner.nextInt();
                    room.addStudents(addStudents);
                    System.out.println("Students added. " + room);
                    break;

                case 'X':
                    System.out.print("Enter the number of students to remove: ");
                    int removeStudents = scanner.nextInt();
                    room.removeStudents(removeStudents);
                    System.out.println("Students removed. " + room);
                    break;

                case 'Y':
                    System.out.print("Enter the light number to turn on (1, 2, or 3): ");
                    int turnOnLight = scanner.nextInt();
                    room.turnOnLight(turnOnLight);
                    System.out.println("Light turned on. " + room);
                    break;

                case 'Z':
                    System.out.print("Enter the light number to turn off (1, 2, or 3): ");
                    int turnOffLight = scanner.nextInt();
                    room.turnOffLight(turnOffLight);
                    System.out.println("Light turned off. " + room);
                    break;

                case 'Q':
                    System.out.println("Quitting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (choice != 'Q');
     scanner.close();
    }
}
