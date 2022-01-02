/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package reflection;

import reflection.model.Person;
import reflection.util.MetaModel;
import reflection.util.MyColumnField;
import reflection.util.MyPrimaryKeyField;

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
