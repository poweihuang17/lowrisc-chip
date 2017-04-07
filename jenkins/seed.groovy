matrixJob('lowrisc_chip_ci_matrix') {
    description 'lowRISC chip test matrix.'

    axes {
         text('TEST_CASE', 'run-asm-tests')
         text('CONFIG', 'DefaultConfig')
    }

    scm {
        git{
            remote {
                url('https://github.com/lowrisc/lowrisc-chip.git')
            }
            extensions {
                submoduleOptions {
                    recursive(true)
                }
            }
        }
    }

    triggers {
        scm('* * * * *')
    }

    wrappers {
        timeout { absolute(15) }
    }

    steps {
        shell ('''
        source set_env.sh
        cd $TOP/riscv-tools
        source build.sh
        ''')
    }

    publishers {
        mailer('wsong83@gmail.com', true, false)
    }
}