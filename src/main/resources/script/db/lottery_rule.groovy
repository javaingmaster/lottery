package script.db

databaseChangeLog(logicalFilePath: 'lottery_rule.groovy') {
    changeSet(id: '2019-01-07-lottery-rule', author: 'zty') {
        createTable(tableName: "lottery_rule") {
            column(name: 'rule_id', type: 'BIGINT UNSIGNED', remarks: 'rule id', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'lottery_object', type: 'TINYINT', remarks: 'lottery object') {
                constraints(nullable: false)
            }

            column(name: 'if_back', type: 'TINYINT', remarks: 'if back') {
                constraints(nullable: false)
            }
            column(name: 'if_public', type: 'TINYINT', remarks: 'if public') {
                constraints(nullable: false)
            }
        }
    }
}