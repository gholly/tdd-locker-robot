
### 存包
1. given:  一个具有2个储物箱的超级机器人, 第一个储物柜，总共4个柜子,其中3个空格 第2个储物箱总共有2个柜子，其中2个空格 when: 交给智能机器人存包 then: 成功把包存入第2个储物箱,返回票据
2. given:  一个具有2个储物箱的超级机器人, 第一个储物柜，总共10个柜子,其中3个空格 第2个储物箱总共有10个柜子，其中3个空格 when: 交给智能机器人存包 then: 成功把包存入第一个储物箱,返回票据
2. given:  一个具有2个储物箱的超级机器人, 第一个储物柜，总共10个柜子,其中3个空格 第2个储物箱总共有10个柜子，其中1个空格 when: 交给智能机器人存包 then: 成功把包存入第1个储物箱,返回票据
3. given: 所有储物箱已满的超级机器人 when: 交给超级机器人存包 then: 存包失败，提示【储物箱已满】

### 取包
1. given: 我已把包存入第一个储物箱，提供合法凭据 when: 把票交给超级机器人，让超级机器人取包 then: 成功取出我的包
2. given: 我已把包存入第二个储物箱，提供合法凭据 when: 把票交给超级机器人，让超级机器人取包 then: 成功取出我的包
3. given: 提供不合法凭据 when: 把票交给超级机器人，让超级机器人取包 then: 取包失败，提示【无效票】