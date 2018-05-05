// Question 1.

db.messages.find({
    "headers.From": "andrew.fastow@enron.com",
    "headers.To": {$in: ["jeff.skilling@enron.com"]}
}).count()

db.messages.find({
    "headers.From": "andrew.fastow@enron.com",
    "headers.To": {$in: ["john.lavorato@enron.com"]}
}).count()

// Question 2.

db.messages.aggregate([
    {
        $project: {
            headers: 1
        }
    },
    {
        $unwind: "$headers.To"
    },
    {
        $group: {
            _id: {
                messageId : "$headers.Message-ID",
                from : "$headers.From",
                to : "$headers.To"
            }
        }
    },
    {
        $group: {
            _id: {
                from: "$_id.from",
                to: "$_id.to"
            },
            total: {$sum: 1}
        }
    },
    {
        $sort: {
            total: -1
        }
    },
    {
        $limit: 5
    }
], { allowDiskUse : true })

// Question 3.

db.messages.update({
    "headers.Message-ID": "<8147308.1075851042335.JavaMail.evans@thyme>"
},{
    $push: {"headers.To": "mrpotatohead@mongodb.com"}
})

// Question 4.

// Java code.

// Question 5.

// a_1_b_1
// a_1_c_1
// c_1
// a_1_b_1_c_-1

// Question 6.

// Remove all indexes from the collection, leaving only the index on _id in place
// Set w=0, j=false on writes

// Question 7.

var db = db.getSiblingDB('photos');

db.albums.createIndex({
    images: 1
});

var photos = db.images.find();
while(photos.hasNext()) {
    var currentPhoto = photos.next();

    var album = db.albums.findOne({
        images: currentPhoto._id
    });

    if(album == null) {
        db.images.deleteOne(currentPhoto);
    }
}

var solution = db.images.find({
    tags: "sunrises"
}).count();

printjson("Result: " + solution);

// Question 8.

// 1

// Question 9.

// patient_id

// Question 10.

// The query avoided sorting the documents because it was able to use an index's ordering.
// The query examined every document in the collection.
