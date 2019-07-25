suite = {
    # --------------------------------------------------------------------------------------------------------------
    #
    #  METADATA
    #
    # --------------------------------------------------------------------------------------------------------------
    "mxversion": "5.190.1",
    "name": "thanos",
    "versionConflictResolution": "latest",

    "version": "1.0.0",
    "release": False,
    "groupId": "org.thanos",

    


    # --------------------------------------------------------------------------------------------------------------
    #
    #  DEPENDENCIES
    #
    # --------------------------------------------------------------------------------------------------------------
    "imports": {
        "suites": [
            {
                "name": "truffle",
                "version": "419d4cc0033ec2c763506a2dcb3fc2e8d00f43a4",
                "subdir": True,
                "urls": [
                    {"url": "https://github.com/oracle/graal", "kind": "git"},
                ]
            }
        ],
    },

    # --------------------------------------------------------------------------------------------------------------
    #
    #  REPOS
    #
    # --------------------------------------------------------------------------------------------------------------
    "repositories": {
    },

    "defaultLicense": "UPL",

    # --------------------------------------------------------------------------------------------------------------
    #
    #  LIBRARIES
    #
    # --------------------------------------------------------------------------------------------------------------
    "libraries": {
    },

    # --------------------------------------------------------------------------------------------------------------
    #
    #  PROJECTS
    #
    # --------------------------------------------------------------------------------------------------------------
    "externalProjects": {
    },


    "projects": {
        "org.thanos": {
            "subDir": "projects",
            "license": ["UPL"],
            "sourceDirs": ["src"],
            "javaCompliance": "1.8",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
            ],
        },
        "org.thanos.test": {
            "subDir": "projects",
            "license": ["UPL"],
            "sourceDirs": ["src"],
            "dependencies": [
                "org.thanos",
                "mx:JUNIT"
            ],
            "checkstyle": "org.thanos",
            "javaCompliance": "1.8",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "testProject": True,
        },
    },

    "licenses": {
        "UPL": {
            "name": "Universal Permissive License, Version 1.0",
            "url": "http://opensource.org/licenses/UPL",
        },
    },

    # --------------------------------------------------------------------------------------------------------------
    #
    #  DISTRIBUTIONS
    #
    # --------------------------------------------------------------------------------------------------------------
    "distributions": {
        "THANOS": {
            "dependencies": [
                "org.thanos",
            ],
            "distDependencies": [
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
            ],
            "sourcesPath": "thanos.src.zip",
            "description": "Thanos",
        },

        "THANOS_UNIT_TESTS": {
            "description": "unit tests",
            "dependencies": [
                "org.thanos.test",
            ],
            "exclude": ["mx:JUNIT"],
            "distDependencies": [
                "THANOS",
            ],
            "sourcesPath": "thanos.tests.src.zip",
            "testDistribution": True,
        },
    },
}
