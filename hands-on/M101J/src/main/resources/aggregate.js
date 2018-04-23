db.posts.aggregate([
    {
        $project: {
            "_id": 0,
            "comments.author": 1
        }
    },
    {
        $unwind: "$comments"
    },
    {
        $group: {
            "_id": "$comments.author",
            sum: {"$sum": 1}
        }
    },
    {
        $sort: {"sum": -1}
    },
])

db.zips.aggregate([
    {
        $group: {
            _id: {state: "$state", city:"$city"},
            pop: {$sum:"$pop"}
        }
    },
    {
        $match: {
            "$and": [{"_id.state": {"$in": ["CA", "NY"]}},
                     {pop: {"$gte": 25000}}]
        }
    },
    {
        $group: {
            _id: null,
            average_pop: {"$avg": "$pop"}
        }
    }
])

db.grades.aggregate([
    {
        $unwind: "$scores"
    },
    {
        $match: {
            "scores.type": {"$in": ["exam", "homework"]}
        }
    },
    {
        $group: {
            _id: {student_id: "$student_id", class_id :"$class_id"},
            average: {"$avg": "$scores.score"}
        }
    },
    {
        $group: {
            _id: "$_id.class_id",
            average: {"$avg": "$average"}
        }
    },
    {
        $sort: {
            average: -1
        }
    }
])
