package designPattern;

interface Animal {
    public void printDescription();
}


class AnimalFactory {
    public static Animal create(String animalName){
        if (animalName == null) {
            return null;
        }
        if (animalName.equals("��")) {
            return new Cow();
        }else if (animalName.equals("������")) {
            return new Cat();
        }else if (animalName.equals("��")) {
            return new Dog();
        }else{
            return null;
        }
    }
}


class Cat implements Animal {
    public void printDescription() {
        System.out.println("����� ����");
    }
}


class Cow implements Animal {
    public void printDescription() {
        System.out.println("���� �� ���� ����");
    }
}


class Dog implements Animal {
    public void printDescription() {
        System.out.println("�ַ� �� ��Ŵ");
    }
}


public class FactoryMethodSample {
    public static void main(String[] args) {
        Animal a1= AnimalFactory.create("��");
        a1.printDescription();
        Animal a2= AnimalFactory.create("������");
        a2.printDescription();
        Animal a3= AnimalFactory.create("��");
        a3.printDescription();
    }
}