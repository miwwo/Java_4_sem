// Интерфейс устройства, которое нуждается в адаптировании
interface Device {
    void turnOn();
}

// Конкретная реализация устройства
class Speaker implements Device {
    public void turnOn() {
        System.out.println("Speaker is turned on");
    }
}

// Интерфейс адаптера
interface Phone {
    void charge();
}

// Адаптер, который позволяет заряжать телефон через устройство типа Device
class PhoneAdapter implements Phone {
    private Device device;

    public PhoneAdapter(Device device) {
        this.device = device;
    }

    public void charge() {
        System.out.println("Phone is being charged");
        device.turnOn();
    }
}

// Пример использования
public class AdapterExample {
    public static void main(String[] args) {
        // Создаем устройство
        Device device = new Speaker();

        // Создаем адаптер и передаем ему устройство
        Phone phone = new PhoneAdapter(device);

        // Подключаем телефон и заряжаем его
        phone.charge(); // Output: Phone is being charged \n Speaker is turned on
    }
}
