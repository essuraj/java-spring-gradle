rootProject.name = "nms"

include("modules:config")
project(":modules:config").name = "config"
include("modules:monitoring")
findProject(":modules:monitoring")?.name = "monitoring"
