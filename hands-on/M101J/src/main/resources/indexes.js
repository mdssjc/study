db.posts.createIndex({'date': -1})
db.posts.createIndex({ permalink: 1}, {unique: true})
