// Интерфейс Document
interface Document {
    void view();
}

// Реальный объект
class SecretDocument implements Document {
    @Override
    public void view() {
        System.out.println("Секретный документ открыт.");
    }
}

// Защитный прокси
class ProxyDocument implements Document {
    private SecretDocument realDoc;
    private String userRole;

    public ProxyDocument(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void view() {
        if ("admin".equals(userRole)) {
            if (realDoc == null) {
                realDoc = new SecretDocument();
            }
            realDoc.view();
        } else {
            System.out.println("Доступ запрещён!");
        }
    }
}

// Класс с методом main для запуска
public class ProxyPattern {
    public static void main(String[] args) {
        // Создаем прокси для пользователя без прав
        Document userDoc = new ProxyDocument("user");
        userDoc.view(); // Выведет "Доступ запрещён!"

        // Создаем прокси для администратора
        Document adminDoc = new ProxyDocument("admin");
        adminDoc.view(); // Выведет "Секретный документ открыт."
    }
}