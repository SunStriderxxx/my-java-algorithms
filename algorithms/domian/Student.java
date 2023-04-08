package domian;

import lombok.*;

/**
 * @author Fcb
 * @date 2020/2/23
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String name;
    private int id;
    private int age;
}
