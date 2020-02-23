package domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Fcb
 * @date 2020/2/23
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private int id;
    private int age;
}
