'use strict';

/**
 * Button right define.
 * name: Recommended are capital letters with hyphens.
 * menuId: only numbers are allowed.
 * @type {{name: menuId}}
 */
const permission = {
    system: {
        user: {
            detail: '1221',
            add: '1222',
            edit: '1223',
            delete: '1224',
        },
        role: {
            detail: '1211',
            add: '1212',
            edit: '1213',
            delete: '1214',
        },
        org: {
            add: '1231',
            edit: '1232',
            delete: '1233',
        }
    }
};

export default permission;
