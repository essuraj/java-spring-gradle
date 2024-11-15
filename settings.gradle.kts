rootProject.name = "nms"

include("modules:config")
project(":modules:config").name = "config"

include("modules:monitoring")
findProject(":modules:monitoring")?.name = "monitoring"

include("modules:common")
findProject(":modules:common")?.name = "common"

include("modules:service-registry")
findProject(":modules:service-registry")?.name = "service-registry"
include("modules:models")
findProject(":modules:models")?.name = "models"
include("modules:auth")
findProject(":modules:auth")?.name = "auth"
