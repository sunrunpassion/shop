package com.fzy.common.valid;

// 关键修改：由 javax 改为 jakarta
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * ListValue 注解的校验器
 * 适配 Jakarta Bean Validation (Spring Boot 3+)
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private final Set<Integer> set = new HashSet<>();

    // 初始化方法：从注解中获取允许的数值
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        if (vals != null) {
            for (int val : vals) {
                set.add(val);
            }
        }
    }

    /**
     * 判断是否校验成功
     *
     * @param value   需要校验的值
     * @param context 校验上下文
     * @return 如果值在指定的 vals 数组中则返回 true，否则返回 false
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 最佳实践：如果值为 null，通常返回 true。
        // 因为“是否为空”应该由 @NotNull 这种注解来处理，
        // 这里的校验器只负责校验“如果值不为空，它是否在范围内”。
        if (value == null) {
            return true;
        }

        return set.contains(value);
    }
}