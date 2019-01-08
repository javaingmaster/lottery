package script.db

databaseChangeLog(logicalFilePath: 'user.groovy') {
    changeSet(id: '2019-01-07-user', author: 'zty') {
        createTable(tableName: "lottery_user") {
            column(name: 'user_id', type: 'BIGINT UNSIGNED', remarks: 'userid', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'user_name', type: 'VARCHAR(20)', remarks: 'username') {
                constraints(nullable: false)
            }
            column(name: 'user_password', type: 'VARCHAR(100)', remarks: 'password') {
                constraints(nullable: false)
            }
            column(name: 'user_role', type: 'TINYINT', remarks: 'role value') {
                constraints(nullable: false)
            }
            column(name: 'user_token', type: 'VARCHAR(100)', remarks: 'token') {
            }
            column(name: 'user_gender', type: 'TINYINT', remarks: 'gender') {
                constraints(nullable: true)
            }
            column(name: 'last_update', type: 'DATETIME', remarks: 'time of last update')
            column(name: 'last_update_by', type: 'VARCHAR(20)', remarks: 'people who change the table at last')
            column(name: 'version', type: 'INT', remarks: 'version for table') {
                constraints(nullable: false)
            }
        }
    }
}