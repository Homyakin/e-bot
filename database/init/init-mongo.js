db.createUser(
    {
        user: "ebot",
        pwd: "12345",
        roles: [
            {
                role: "readWrite",
                db: "ebase"
            }
        ]
    }
);