package script.db

databaseChangeLog(logicalFilePath: 'activity_user_group.groovy') {
    changeSet(id: '2019-01-07-activity-user-group', author: 'zty') {
        createTable(tableName: "activity_user_group") {
            column(name: 'aug_id', type: 'BIGINT UNSIGNED', remarks: 'aug id', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'activity_id', type: 'BIGINT UNSIGNED', remarks: 'user id') {
                constraints(nullable: false)
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