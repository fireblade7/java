package designPattern;

interface Seller {
    public void sell();
}

class CupSeller implements Seller {
    public void sell() {
        System.out.println("���� �Ⱦƿ�.");
    }
}

class PhoneSeller implements Seller {
    public void sell() {
        System.out.println("��ȭ�⸦ �Ⱦƿ�.");
    }
}

class Mart {
    private Seller seller;
    public Mart(Seller seller) {
        this.seller = seller;
    }
    public void order(){
        seller.sell();
    }
}

public class StrategySample {
    public static void main(String[] args) {
        Seller cupSeller = new CupSeller();
        Seller phoneSeller = new PhoneSeller();
        Mart mart1 = new Mart(cupSeller);
        mart1.order();
        Mart mart2 = new Mart(phoneSeller);
        mart2.order();
    }
}
