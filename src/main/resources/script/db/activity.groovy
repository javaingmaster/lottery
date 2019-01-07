package script.db

databaseChangeLog(logicalFilePath: 'activity.groovy') {
    changeSet(id: '2019-01-07-activity', author: 'zty') {
        createTable(tableName: "lottery_activity") {
            column(name: 'activity_id', type: 'BIGINT UNSIGNED', remarks: 'activityid', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'activity_name', type: 'VARCHAR(20)', remarks: 'activity name') {
                constraints(nullable: false)
            }
            column(name: 'activity_description', type: 'VARCHAR(100)', remarks: 'description of activity') {
                constraints(nullable: true)
            }
            column(name: 'activity_time', type: 'DATETIME', remarks: 'start time of activity') {
                constraints(nullable: true)
            }
        }
    }
}