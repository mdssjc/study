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
