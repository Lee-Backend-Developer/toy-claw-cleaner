package com.apple.toyclawcleaner.user.request

import com.apple.toyclawcleaner.common.Request

class UserSignIn (
    var loginId: String,
    var password: String,
) : Request()