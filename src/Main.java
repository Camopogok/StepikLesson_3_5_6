import javax.swing.*;


public class Main {

static String login = null;
static String password = null;

    public static void main(String[] args) {

        Registration r = new Registration();
        if (r.startWindow() == JOptionPane.YES_OPTION) {
            login = r.loginInput();
            while (!((login == null) || r.checkLogin(login))) {
                JOptionPane.showMessageDialog(null, "Логин должен содержать больше 5 символов");
                login = r.loginInput();
            }
        } else {
            r.goodLuck();
            return;
        }
        if (login == null) {
            r.goodLuck();
            return;
        }
        password = r.passwordInput();
        while (!((password == null) || r.checkPassword(password))) {
            JOptionPane.showMessageDialog(null, "Пароль должен содержать: \n" +
                    " - больше 8 символов;\n" +
                    " - как минимум 1 букву;\n" +
                    " - как минимум 1 цифру.");
            password = r.passwordInput();
        }
        if (password == null) {
            r.goodLuck();
            return;
        }
        String password2 = r.repeatPassword();
        while (!password.equals(password2)) {
              password2 = r.repeatPassword();
        }
        r.congratulation();
    }

}
class Registration {
    Registration () {
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.okButtonText", "Готово");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
    }

    public int startWindow () {
        return JOptionPane.showConfirmDialog(null, "Вы хотите зарегистрироваться?", "Регистрация", JOptionPane.YES_NO_OPTION);
    }

    public String loginInput () {
        return JOptionPane.showInputDialog(null, "Введите логин:", "Логин", JOptionPane.QUESTION_MESSAGE);
    }

    public String passwordInput () {
        JPasswordField pass = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pass, "Ведите пароль", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (new String(pass.getPassword()).equals(""))
            return null;
        return new String(pass.getPassword());
    }

    public String repeatPassword () {
        JPasswordField pass = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pass, "Повторите пароль", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (new String(pass.getPassword()).equals(""))
            return null;
        return new String(pass.getPassword());
    }

    public boolean checkLogin (String s) {
        if (s == null) return false;

        return s.length() > 5 && !s.contains(" ");
    }

    public boolean checkPassword (String s) {
        if (s == null) return false;
            else
        return s.length() > 8 && containLetter(s) && containNumber(s);
    }
    public void goodLuck () {
        JOptionPane.showMessageDialog(null, "       Всего доброго!");
    }

    public void congratulation () {
        JOptionPane.showMessageDialog(null, "   Регистрация прошла успешно!");
    }

    public boolean containLetter (String s) {
        s = s.toLowerCase();
        char [] a = s.toCharArray();
        for (char aaa: a) {
            if ((aaa >= 'a' && aaa <= 'z') || (aaa >= 'а' && aaa <= 'я'))
                return true;
        }
        return false;
    }

    public boolean containNumber (String s) {
        char [] a = s.toCharArray();
        for (char aaa: a) {
            if (aaa >= '0' && aaa <= '9')
                return true;
        }
        return false;
    }
}
