'use strict';

/**
 * Button right define.
 * name: Recommended are capital letters with hyphens.
 * menuId: only numbers are allowed.
 * @type {{name: menuId}}
 */
const permission = {
    system: {
        param: {
            edit: '1121',
            reset: '1122',
        },
        role: {
            detail: '1211',
            add: '1212',
            edit: '1213',
            delete: '1214',
        },
        user: {
            detail: '1221',
            add: '1222',
            edit: '1223',
            delete: '1224',
            grantrole: '1225',
            resetpassword: '1226',
            freeze: '1227',
            unfreeze: '1228',
        },
        org: {
            add: '1231',
            edit: '1232',
            delete: '1233',
        }
    }
};

export default permission;
