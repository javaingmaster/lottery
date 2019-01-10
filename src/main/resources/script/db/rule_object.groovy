package script.db

databaseChangeLog(logicalFilePath: 'rule_object.groovy') {
    changeSet(id: '2019-01-07-rule-object', author: 'zty') {
        createTable(tableName: "rule_object") {
            column(name: 'rule_object_id', type: 'BIGINT UNSIGNED', remarks: 'rule object id', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'rule_id', type: 'BIGINT UNSIGNED', remarks: 'rule id') {
                constraints(nullable: false)
            }
            column(name: 'lottery_object_id', type: 'BIGINT UNSIGNED', remarks: 'object id') {
            }
            column(name: 'object_ratio', type: 'FLOAT', remarks: 'object ratio') {
                constraints(nullable: true)
            }
        }
    }
}