/*
 * Author: Kartik Gola
 * Date: 2/28/21, 5:54 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package fundamentals.reflection;

import fundamentals.reflection.model.Person;
import fundamentals.reflection.util.MetaModel;
import fundamentals.reflection.util.MyColumnField;
import fundamentals.reflection.util.MyPrimaryKeyField;

import java.util.List;

public class MetaModelPlayground {

    public static void main(String[] args) {
        MetaModel<Person> metaModel = MetaModel.of(Person.class);

        MyPrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        List<MyColumnField> columnFieldList = metaModel.getColumns();

        System.out.println(primaryKeyField);
        columnFieldList.forEach(System.out::println);
    }
}
