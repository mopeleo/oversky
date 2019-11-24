<template>
    <div>
        <el-form ref="calendarForm">
            <el-calendar v-model="value">
            </el-calendar>
        </el-form>
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: 'syswork_calendar',
    data(){
        return {
            value: new Date()
        }
    }
}
</script>
