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
