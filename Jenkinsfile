pipeline {
  agent any
  stages {
    stage('fetch') {
      steps {
        sh '''git clone -b minion-v0.4 --recursive https://github.com/lowrisc/lowrisc-chip.git lowrisc-chip-minion-v0.4


'''
      }
    }
    stage('cd') {
      steps {
        dir(path: 'lowrisc-chip-minion-v0.4')
      }
    }
    stage('set_env') {
      steps {
        sh 'source set_env.sh'
      }
    }
    stage('cd fpga') {
      steps {
        dir(path: 'fpga/board/nexys4_ddr')
      }
    }
    stage('bitstream') {
      steps {
        sh 'make bitstream'
      }
    }
  }
}