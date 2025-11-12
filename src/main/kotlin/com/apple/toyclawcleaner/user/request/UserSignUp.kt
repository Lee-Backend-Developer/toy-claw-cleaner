package com.apple.toyclawcleaner.user.request

import com.apple.toyclawcleaner.common.Request

class UserSignUp (
    var loginId: String,
    var password: String,
    var name: String,
) : Request()