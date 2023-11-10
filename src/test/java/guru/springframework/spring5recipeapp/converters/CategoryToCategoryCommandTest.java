package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.Domain.Category;
import guru.springframework.spring5recipeapp.commands.CategoryCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CategoryToCategoryCommandTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand convert;

    @BeforeEach
    void setUp() {
        convert = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        Assertions.assertNull(convert.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        Assertions.assertNotNull(convert.convert(new Category()));
    }


    @Test
    void convert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convert.convert(category);

        //then
        assert categoryCommand != null;
        Assertions.assertEquals(ID_VALUE, categoryCommand.getId());
        Assertions.assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}