package script.db

databaseChangeLog(logicalFilePath: 'user_group.groovy') {
    changeSet(id: '2019-01-07-user-group', author: 'zty') {
        createTable(tableName: "user_group") {
            column(name: 'user_group_id', type: 'BIGINT UNSIGNED', remarks: 'user group id', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED', remarks: 'user id') {
                constraints(nullable: false)
            }
            column(name: 'group_id', type: 'BIGINT UNSIGNED', remarks: 'group id') {
                constraints(nullable: false)
            }

        }
    }
}