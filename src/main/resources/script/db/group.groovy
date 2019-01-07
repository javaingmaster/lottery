package script.db

databaseChangeLog(logicalFilePath: 'group.groovy') {
    changeSet(id: '2019-01-07-group', author: 'zty') {
        createTable(tableName: "lottery_group") {
            column(name: 'group_id', type: 'BIGINT UNSIGNED', remarks: 'groupid', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'group_name', type: 'VARCHAR(20)', remarks: 'name of group') {
                constraints(nullable: false)
            }

            column(name: 'group_captain', type: 'BIGINT UNSIGNED', remarks: 'captain id') {
                constraints(nullable: true)
            }
        }
    }
}