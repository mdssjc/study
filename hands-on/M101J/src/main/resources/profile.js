db.sysprofile.find({op : "query"}).sort({millis : -1}).limit(1).pretty()
