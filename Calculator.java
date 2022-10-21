public class Calculator {


    public static NumList big_add(NumList list1, NumList list2) {
        NumList.reverse(list1);
        NumList.reverse(list2);
        NumList fin = new NumList();
        int carry = 0;
        int temp = 0;

        while (list1 != null && list2 != null) {
            temp = list1.get().getnum() + list2.get().getnum();
            if (carry > 0) {
                temp += carry;
                carry = 0;
            }
            carry = temp / 10;
            temp = temp % 10;
            fin.insert(temp);
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1 == null && list2 != null) {
            while (list2 != null) {
                temp = list2.get().getnum();
                if (carry > 0) {
                    temp += carry;
                    carry = 0;
                }
                carry = temp / 10;
                temp = temp % 10;
                fin.insert(temp);
                list2 = list2.next;
            }
        } else if (list1 != null && list2 == null) {
            while (list1 != null) {
                temp = list1.get().getnum();
                if (carry > 0) {
                    temp += carry;
                    carry = 0;
                }
                carry = temp / 10;
                temp = temp % 10;
                fin.insert(temp);
                list1 = list1.next;
            }
            if (carry > 0)
                fin.insert(carry);
        }

        return fin;
    }

    public static NumList big_mult(NumList list1, NumList list2) {
        int num = 0;
        int num1 = 0;
        NumList.reverse(list1);
        NumList.reverse(list2);
        NumList finlist = new NumList();
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                num = num * 10 + list1.get().getnum();
                list1 = list1.next;
            }
            if (list2 != null) {
                num1 = num1 * 10 + list2.get().getnum();
                list2 = list2.next;
            }

            finlist.insert(num1 * num);

        }
        return finlist;
    }

    public static NumList big_exp(NumList base, int exp) {
        NumList total = base;
        int new_exp = 1;
        NumList finlist = new NumList();
        finlist.insert(1);
        if (exp == 0)
            return finlist;
        while ((2 * new_exp) <= exp)
        {
            total = big_mult(total, total);
            new_exp *= 2;
        }
        return big_mult(total, big_exp(base, exp - new_exp));
    }
}

