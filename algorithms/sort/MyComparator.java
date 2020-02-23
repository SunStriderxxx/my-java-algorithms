package sort;

import domian.Student;

import java.util.Comparator;

/**
 * @author Fcb
 * @date 2020/2/23
 * @description
 */
public class MyComparator implements Comparator<Student> {


    /**
     * @author Fcb
     * @date 2020/2/23
     * @description
     * 返回正数，o1>o2
     * 返回负数，o1<o2,
     * 返回0，o1=o2
     * 最后的排序是从小到大排
     */

    //返回正数，o1>o2
    //返回负数，o1<o2,
    //返回0，o1=o2
    //最后的排序是从小到大排
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() - o2.getId();
    }
}
