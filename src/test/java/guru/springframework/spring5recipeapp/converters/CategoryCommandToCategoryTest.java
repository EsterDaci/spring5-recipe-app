package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.Domain.Category;
import guru.springframework.spring5recipeapp.commands.CategoryCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class CategoryCommandToCategoryTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assert category != null;
        Assertions.assertEquals(ID_VALUE, category.getId());
        Assertions.assertEquals(DESCRIPTION, category.getDescription());
    }
    @Test
    public void testNullObject() throws Exception {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        Assertions.assertNotNull(converter.convert(new CategoryCommand()));
    }


}