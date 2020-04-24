package Commons;

import java.util.regex.Pattern;

public class ValidateData {
    private static String pattern = "";
    private static Pattern regex;
    public static boolean validateNameService(String name) {
        pattern = ("^[A-Z][a-z]+(?:[\\s]+[A-Z][a-z]+)*$");
        regex = Pattern.compile(pattern);
        if (name.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Tên Viết không dấu và in hoa ký tự đầu tiên");
        return false;
    }

    public static boolean validateRentalCosts(double rentalCosts) {
        if (rentalCosts > 0) {
            return true;
        } else {
            System.out.println("Chi phí thuê phải là số thực dương ");
            return false;
        }
    }

    public static boolean validateAreaUsedAndPool(double areaUsed) {
        if (areaUsed > 30) {
            return true;
        } else {
            System.out.println("diện tích sử dụng phải lớn hơn 30m^2");
            return false;
        }
    }

    public static boolean validateNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople > 0 && numberOfPeople < 20) {
            return true;
        } else {
            System.out.println("số lượng người phải nhỏ hơn 20");
            return false;
        }
    }

    public static boolean validateNumberOfFloor(int numberOfFloor) {
        if (numberOfFloor > 0) {
            return true;
        } else {
            System.out.println("số tầng không thể âm");
            return false;
        }
    }

    public static boolean validateNameCustomer(String nameCustomer) {
        pattern = ("^[A-Z][a-z_àáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]" +
                "+(?:[\\s]+[A-Z][a-z_àáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)*$");
        regex = Pattern.compile(pattern);
        if (nameCustomer.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("Tên khách hàng viết dấu và in hoa ký tự đầu tiên");
        return false;
    }

    public static boolean validateBirthday(String birthday) {
        pattern = ("^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$");
        regex = Pattern.compile(pattern);
        if (birthday.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("ngày sinh không đúng định dạng dd-mm-yyyy");
        return false;
    }

    public static boolean validateAccompaniedService(String accompaniedService) {
        pattern = ("^(karaoke)|(rent car)|(massage)|(food)|(drinks)$");
        regex = Pattern.compile(pattern);
        if (accompaniedService.matches(String.valueOf(regex))) {
            return true;
        }
        System.out.println("dịch vụ di kèm không nằm trong hóa đơn (karaoke|rent car|massage|food|drinks)");
        return false;
    }

    public static boolean validateEmail(String email) {
        pattern = ("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        regex = Pattern.compile(pattern);
        if (email.matches(String.valueOf(regex))) {
            return true;
        } else {
            System.out.println("email không đúng định dạng!");
            return false;
        }
    }

    public static boolean validateIdCard(String idCard) {
        pattern = ("^([0-9]{9})$");
        regex = Pattern.compile(pattern);
        if (idCard.matches(String.valueOf(regex))) {
            return true;
        } else {
            System.out.println("idCard phải đúng 9 chữ số!");
            return false;
        }
    }

    public static boolean validateGender(String gender) {
        pattern = ("^(male)|(female])|(unknow)$");
        regex = Pattern.compile(pattern);
        if (gender.matches(String.valueOf(regex))) {
            return true;
        } else {
            System.out.println("Gender phải là Male, Female, Unknow");
            return false;
        }
    }

    public static boolean validateNumberPhone(String numberPhone) {
        pattern = ("^[0-9]{9,10}$");
        regex = Pattern.compile(pattern);
        if (numberPhone.matches(String.valueOf(regex))) {
            return true;
        } else {
            System.out.println("số điện thoại không đúng");
            return false;
        }
    }

    public static boolean validateTypeRent(String gender) {
        pattern = ("^(day)|(hour)|(week)$");
        regex = Pattern.compile(pattern);
        if (gender.matches(String.valueOf(regex))) {
            return true;
        } else {
            System.out.println("Gender phải là day, hour, week");
            return false;
        }
    }
}
